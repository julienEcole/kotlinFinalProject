package com.example.kotlinfinalproject.services.dtos

import com.google.gson.annotations.SerializedName
import kotlin.reflect.full.memberProperties

data class TotalNutrients(
    @SerializedName("CA")
    val cA: Nutrient?,
    @SerializedName("CHOCDF")
    val cHOCDF: Nutrient?,
    @SerializedName("CHOCDF.net")
    val cHOCDFNet: Nutrient?,
    @SerializedName("CHOLE")
    val cHOLE: Nutrient?,
    @SerializedName("ENERC_KCAL")
    val eNERCKCAL: Nutrient?,
    @SerializedName("FAMS")
    val fAMS: Nutrient?,
    @SerializedName("FAPU")
    val fAPU: Nutrient?,
    @SerializedName("FASAT")
    val fASAT: Nutrient?,
    @SerializedName("FAT")
    val fAT: Nutrient?,
    @SerializedName("FATRN")
    val fATRN: Nutrient?,
    @SerializedName("FE")
    val fE: Nutrient?,
    @SerializedName("FIBTG")
    val fIBTG: Nutrient?,
    @SerializedName("FOLAC")
    val fOLAC: Nutrient?,
    @SerializedName("FOLDFE")
    val fOLDFE: Nutrient?,
    @SerializedName("FOLFD")
    val fOLFD: Nutrient?,
    @SerializedName("K")
    val k: Nutrient?,
    @SerializedName("MG")
    val mG: Nutrient?,
    @SerializedName("NA")
    val nA: Nutrient?,
    @SerializedName("NIA")
    val nIA: Nutrient?,
    @SerializedName("P")
    val p: Nutrient?,
    @SerializedName("PROCNT")
    val pROCNT: Nutrient?,
    @SerializedName("RIBF")
    val rIBF: Nutrient?,
    @SerializedName("SUGAR")
    val sUGAR: Nutrient?,
    @SerializedName("SUGAR.added")
    val sUGARAdded: Nutrient?,
    @SerializedName("THIA")
    val tHIA: Nutrient?,
    @SerializedName("TOCPHA")
    val tOCPHA: Nutrient?,
    @SerializedName("VITA_RAE")
    val vITARAE: Nutrient?,
    @SerializedName("VITB12")
    val vITB12: Nutrient?,
    @SerializedName("VITB6A")
    val vITB6A: Nutrient?,
    @SerializedName("VITC")
    val vITC: Nutrient?,
    @SerializedName("VITD")
    val vITD: Nutrient?,
    @SerializedName("VITK1")
    val vITK1: Nutrient?,
    @SerializedName("WATER")
    val wATER: Nutrient?,
    @SerializedName("ZN")
    val zN: Nutrient?
) {
    fun toTotalNutrients(): List<Nutrient> {
        val nutrientProperties = this::class.memberProperties
        val result = mutableListOf<Nutrient>()
        var nutrientInstance: Nutrient?

        for (nutrientProperty in nutrientProperties) {
            nutrientInstance = nutrientProperty.getter.call(this) as Nutrient?
            if (nutrientInstance !== null) {
                result.add(nutrientInstance)
            }
        }

        return result
    }
}
