package com.ourobouse.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ourobouse.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import java.net.Authenticator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    MainSurface()
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun MainSurface(){
    val buttonStatus = remember { mutableStateOf(false) }
    Column(Modifier.padding(2.dp)) {
        Card(shape = RoundedCornerShape(20.dp),
            modifier = Modifier.padding(30.dp),
        backgroundColor = MaterialTheme.colors.primary) {
            Row(modifier = Modifier.size(width = 320.dp, height = 140.dp)) {
                Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "test",
                modifier = Modifier.clip(RoundedCornerShape(20.dp)).padding(20.dp))
                Column (modifier = Modifier.padding(8.dp)){
                    Text(text = "left")
                    Text(text = "left down")
                }
                Column(modifier = Modifier.padding(2.dp)) {
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedButton(onClick = { buttonStatus.value = !buttonStatus.value }) {
                        Text(if (buttonStatus.value) "expanded" else "none")
                    }

                }


            }

        }
        Card(shape = RoundedCornerShape(20.dp), modifier = Modifier.padding(40.dp)) {
            Row(modifier = Modifier.padding(10.dp)) {
                Text(text = "test")
            }
        }
    }



}

data class QQleaks(val phone: String, val QQ: String)
data class Weiboleaks(val Phone: String, val uid: String)
val client = KMongo.createClient() //get com.mongodb.MongoClient new instance
val database = client.getDatabase("SEL") //normal java driver usage
val colQQleaks = database.getCollection<QQleaks>() //KMongo extension method
val colWeiboLeaks = database.getCollection<Weiboleaks>()

class MongoDB(val dbAdress: String,
              val userName: String,
              val passWord: String,
              val cryptoType: String){
    fun Connect(dbAdress: String, userName: String, passWord: String, cryptoType: String){

    }
}