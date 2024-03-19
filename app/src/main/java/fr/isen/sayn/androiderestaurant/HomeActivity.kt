package fr.isen.sayn.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.sayn.androiderestaurant.ui.theme.AndroidERestaurantTheme

class HomeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidERestaurantTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text(stringResource(id = R.string.app_name))
                            }
                        )
                    },
                ){
                    Home(innerPaddingValues = it)
                        goToCategory(category)
                }
            }
        }
    }
    private fun goToCategory (category: String){
        Toast.makeText(
            this,
            "Vous avez cliquer sur $category",
            Toast.LENGTH_SHORT
        )
        val intent = Intent(this,CategoryActivity::class.java)
        intent.putExtra("category", category)
        startActivity(intent)
    }
}

@Composable
fun Home(innerPaddingValues: PaddingValues) {
    val context = LocalContext.current
    val starters =
    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(32.dp)
        ){
            Spacer(modifier = Modifier.width(32.dp))
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = stringResource(id = R.string.home_welcome),
                    fontSize = 40.sp,
                    color = Color(0xFFFF9422),
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
                Text(
                    text = stringResource(id = R.string.home_welcome2),
                    fontSize = 24.sp,
                    color = Color(0xFFA75B09),
                    textAlign = TextAlign.End,
                    fontFamily = FontFamily(Font(R.font.magicspark))
                )
            }
            Image(
                painter = painterResource(id = R.drawable.drodro),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .height(160.dp)
                    .padding(top = 8.dp)
                    .fillMaxWidth(0.5f)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop
            )}

        Text(
            text = stringResource(id = R.string.home_starters),
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(horizontal = 16.dp, vertical = 42.dp)
                .clickable { goToCategory(starters) }
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
            text = stringResource(id = R.string.home_dish),
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(horizontal = 16.dp, vertical = 42.dp)
                .clickable { goToCategory(dish) }
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
            text = stringResource(id = R.string.home_desserts),
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(horizontal = 16.dp, vertical = 42.dp)
                .clickable { goToCategory(desserts) }
        )
    }
}