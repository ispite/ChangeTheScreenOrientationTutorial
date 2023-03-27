package com.example.changethescreenorientationtutorial

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.changethescreenorientationtutorial.ui.theme.ChangeTheScreenOrientationTutorialTheme
import com.example.changethescreenorientationtutorial.ui.theme.greenColor

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChangeTheScreenOrientationTutorialTheme {
                // on below line we are specifying
                // background color for our application
                Surface(
                    // on below line we are specifying
                    // modifier and color for our app
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {

                    // on the below line we are specifying
                    // the theme as the scaffold.
                    Scaffold(

                        // in scaffold we are
                        // specifying the top bar.
                        topBar = {

                            // inside top bar we are specifying
                            // background color.
                            TopAppBar(backgroundColor = greenColor,

                                // along with that we are specifying
                                // title for our top bar.
                                title = {

                                    // in the top bar we are specifying
                                    // title as a text
                                    Text(
                                        // on below line we are specifying
                                        // text to display in top app bar.
                                        text = "GFG",

                                        // on below line we are specifying
                                        // modifier to fill max width.
                                        modifier = Modifier.fillMaxWidth(),

                                        // on below line we are specifying
                                        // text alignment.
                                        textAlign = TextAlign.Center,

                                        // on below line we are specifying
                                        // color for our text.
                                        color = Color.White
                                    )
                                })
                        }) { it ->
                        Log.d("TAG", "onCreate: $it")
                        // on below line we are calling our
                        // method to display UI
                        screenOrientation(LocalContext.current)
                    }
                }
            }
        }
    }

}

@Composable
fun screenOrientation(
    context: Context,
) {

    // on below line creating a
    // variable for screen orientation.
    val portrait = remember {
        mutableStateOf(true)
    }
    val activity = context as Activity
    // on below line we are creating a column,
    Column(
        // on below line we are adding a modifier to it,
        modifier = Modifier
            .fillMaxSize()
            // on below line we are adding a padding.
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        // on below line we are adding a text for heading.
        Text(
            // on below line we are specifying text
            text = "Welcome to Geeks for Geeks",
            // on below line we are specifying text color,
            // font size and font weight
            color = greenColor, fontSize = 20.sp, fontWeight = FontWeight.Bold
        )

        // on below line adding a spacer.
        Spacer(modifier = Modifier.height(20.dp))

        // on below line creating a button
        Button(onClick = {
            // on below line we are
            // changing screen orientation
            if (portrait.value) {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            } else {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }

            // opposite the value of isPortrait
            portrait.value = !portrait.value

        }, modifier = Modifier.width(300.dp)) {
            // on below line adding a text for our button.
            Text(text = "Change Screen Orientation", color = Color.White)
        }
    }
}

/*@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}*/

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChangeTheScreenOrientationTutorialTheme {
//        Greeting("Android")
        screenOrientation(LocalContext.current)
    }
}