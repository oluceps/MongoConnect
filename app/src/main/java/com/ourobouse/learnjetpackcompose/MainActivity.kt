package com.ourobouse.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ourobouse.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import org.litote.kmongo.text
import java.net.Authenticator
import kotlin.math.round

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
                    Column {

                        MainSurface()

                        InquireCard()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun MainSurface(){
    val connectStatus= remember {
        mutableStateOf(false)
    }

        Card(border = ButtonDefaults.outlinedBorder,

            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
            ) {
           Row(horizontalArrangement = Arrangement.Start) {
               Column (verticalArrangement = Arrangement.Center,
               modifier = Modifier
                   .padding(20.dp)
                   .defaultMinSize(minWidth = 140.dp)){
                   fun textCon(status: Boolean): String {
                       return if (!status) "Disconnected" else "Connected"
                   }


                   Text(text = textCon(connectStatus.value), Modifier.padding(15.dp)
                   )

                   Text(text = "Type:  ${if (!connectStatus.value) "-" else null/*TODO else*/}",
                       Modifier.padding(15.dp)
                   )

                   Text(text = "User: ",
                   Modifier.padding(15.dp))
                   }

               Column(verticalArrangement = Arrangement.SpaceAround){

                   Spacer(modifier = Modifier.height(6.dp))

                   OutlinedButton(onClick = { connectStatus.value = !connectStatus.value},
                   modifier = Modifier.size(width = 180.dp, height = 180.dp)) {

                       Image(painter = if (connectStatus.value) painterResource(id = R.drawable.ic_baseline_check_circle_24)
                       else painterResource(id = R.drawable.ic_baseline_highlight_off_24),
                           contentDescription = "No connected",
                           modifier = Modifier
                               .fillMaxSize()
                       )
                   }
               }
           }
        }

}

@Preview
@Composable
fun InquireCard(){
    Card(border = ButtonDefaults.outlinedBorder,
    modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .height(120.dp)) {
        Text(text = "test", modifier = Modifier.fillMaxSize())

    }
}




data class QQleaks(val phone: String, val QQ: String)
data class Weiboleaks(val Phone: String, val uid: String)

class MongoDB(val dbAdress: String,
              val userName: String,
              val passWord: String,
              val cryptoType: String){

    fun connectDB(dbName: String){
        val client = KMongo.createClient("mongodb://localhost")//get com.mongodb.MongoClient new instance
        val database = client.getDatabase(dbName) //normal java driver usage
        val colQQleaks = database.getCollection<QQleaks>() //KMongo extension method
        val colWeiboLeaks = database.getCollection<Weiboleaks>()
    }


    fun Connect(dbAdress: String,
                userName: String,
                passWord: String,
                cryptoType: String){


    }
}

