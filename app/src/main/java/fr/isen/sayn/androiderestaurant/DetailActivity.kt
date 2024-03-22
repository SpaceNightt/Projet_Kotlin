package fr.isen.sayn.androiderestaurant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.isen.sayn.androiderestaurant.ui.theme.AndroidERestaurantTheme
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import com.google.gson.Gson
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.graphics.painter.Painter
import coil.compose.rememberImagePainter
import androidx.compose.runtime.*



class DetailActivity : ComponentActivity() {
    // Déclaration d'une variable d'état pour stocker les éléments récupérés à partir de l'API
    var menuItems by mutableStateOf<List<MenuItem>>(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val requestQueue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"

        val idShop = JSONObject()
        idShop.put("id_shop", "1")

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST, url, idShop,
            { response ->
                // Traitement de la réponse de l'API
                Log.d("Response", response.toString())
                // Parsing de la réponse JSON et filtrage
                menuItems = parseJsonAndFilter(response, "selectedCategory")
            },
            { error ->
                // Gestion des erreurs de requête
                Log.e("Error", error.toString())
            }
        )

        requestQueue.add(jsonObjectRequest)

        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Affichage des éléments récupérés à partir de l'API
                    if (menuItems.isNotEmpty()) {
                        // Affichage des éléments de la liste
                        menuItems.forEach { menuItem ->
                            MenuItemCell(menuItem = menuItem)
                        }
                    } else {
                        // Affichage d'un indicateur de chargement ou de message d'erreur
                        Text(text = "Chargement en cours...")
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidERestaurantTheme {
        Greeting("Android")
    }
}

// Définir la classe de modèle pour votre réponse JSON
data class MenuItem(
    val title: String,
    val category: String,
    val image: String,
    val price: Double
)

fun parseJsonAndFilter(response: JSONObject, selectedCategory: String): List<MenuItem> {
    val gson = Gson()
    val menuItems = gson.fromJson(response.getJSONArray("data").toString(), Array<MenuItem>::class.java)
    return menuItems.filter { it.category == selectedCategory }
}

@Composable
fun LoadImageFromUrl(url: String) {
    val painter: Painter = rememberImagePainter(url)
    Image(painter = painter, contentDescription = null)
}

@Composable
fun MenuItemCell(menuItem: MenuItem) {
    // Modifier cette fonction selon vos besoins pour afficher le titre, l'image et le prix du plat
    Column {
        Text(text = menuItem.title)
        LoadImageFromUrl(url = menuItem.image)
        Text(text = "Prix : ${menuItem.price} €")
    }
}
