package fr.isen.sayn.androiderestaurant

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Divider
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import fr.isen.sayn.androiderestaurant.ui.theme.AndroidERestaurantTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidERestaurantTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    WelcomeMessage()
                    MainNav{
                        text -> showToast(text)
                    }
                }

            }
        }
    }
    fun showToast (text: String){
        Toast.makeText(
            this,
            "Catégorie : $text",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun selectCategory(){

    }
}

@Composable
fun WelcomeMessage() {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
    ) {
        Spacer(modifier = Modifier.width(32.dp))
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .padding(end = 16.dp)
        ) {
            Text(
                text = "Bienvenue\n chez\n",
                fontSize = 40.sp,
                color = Color(0xFFFF9422),
                textAlign = TextAlign.End,
            )
            Text(
                text = "DroidRestaurant",
                fontSize = 24.sp,
                color = Color(0xFFA75B09),
                textAlign = TextAlign.End,
                fontFamily = FontFamily(Font(R.font.magicspark))
            )
        }
        Image(
            painter = painterResource(id = R.drawable.drodro),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
    }
}

@Composable
fun MainNav(showToast: (String) -> Unit){
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Entree",
                fontSize = 24.sp,
                color = Color(0xFFA75B09),
                textAlign = TextAlign.End,
            )
            Divider(
                color = Color(0xFFA75B09),
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
                    .padding(start = 50.dp, end = 50.dp) // Ajouter des marges à gauche et à droite
            )
            Text(
                text = "Plats",
                fontSize = 24.sp,
                color = Color(0xFFA75B09),
                textAlign = TextAlign.End,
            )
            Divider(
                color = Color(0xFFA75B09),
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
                    .padding(start = 50.dp, end = 50.dp) // Ajouter des marges à gauche et à droite
            )
            Text(
                text = "Desserts",
                fontSize = 24.sp,
                color = Color(0xFFA75B09),
                textAlign = TextAlign.End,
            )
        }
    }
}
