package fr.isen.sayn.androiderestaurant.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Prices (

  @SerializedName("id"          ) var id         : String? = null,
  @SerializedName("id_pizza"    ) var idPizza    : String? = null,
  @SerializedName("id_size"     ) var idSize     : String? = null,
  @SerializedName("price"       ) var price      : String? = null,
  @SerializedName("create_date" ) var createDate : String? = null,
  @SerializedName("update_date" ) var updateDate : String? = null,
  @SerializedName("size"        ) var size       : String? = null

): Serializable