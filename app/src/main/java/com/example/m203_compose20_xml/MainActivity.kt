package com.example.m203_compose20_xml

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.m203_compose20_xml.ui.theme.M203_Compose20_XMLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M203_Compose20_XMLTheme {
                CustomXmlView()
            }
        }
    }
}

@Composable
fun CustomXmlView() {
    // Utilisation d'AndroidView pour intégrer la vue XML
    AndroidView(
        factory = { context ->
            // Infle le fichier XML et retourne la vue
            LayoutInflater.from(context).inflate(R.layout.custom_view, null, false)
        },
        modifier = Modifier.fillMaxWidth(),
        update = { view ->
            // Accès à la vue XML pour des mises à jour dynamiques
            val textView: TextView = view.findViewById(R.id.textView)
            val button: Button = view.findViewById(R.id.button)

            textView.text = "Updated from Compose!"
            button.setOnClickListener {
                textView.text = "Button clicked!"
            }
        }
    )
}