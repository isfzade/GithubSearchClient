package az.isfan.test3205.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import az.isfan.test3205.navigation.NavGraph
import az.isfan.test3205.ui.theme.Test3205Theme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test3205Theme {
                NavGraph()
            }
        }
    }
}