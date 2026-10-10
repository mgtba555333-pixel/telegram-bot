package com.pixelchief.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val bg = Color(0xFF0B1120)
            var running by remember { mutableStateOf(false) }
            MaterialTheme(colorScheme = darkColorScheme(primary = Color(0xFFF59E0B), background = bg, surface = Color(0xFF172033))) {
                Column(
                    modifier = Modifier.fillMaxSize().background(bg).padding(22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("PIXELCHIEF", fontSize = 30.sp, fontWeight = FontWeight.Black, color = Color(0xFFF59E0B))
                    Text("Android companion", color = Color.LightGray, modifier = Modifier.padding(top = 4.dp, bottom = 28.dp))
                    Card(shape = RoundedCornerShape(18.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF172033))) {
                        Column(Modifier.padding(20.dp)) {
                            Text("Bot status", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text(if (running) "Running (demo mode)" else "Stopped", color = if (running) Color(0xFF4ADE80) else Color(0xFFCBD5E1), modifier = Modifier.padding(top = 8.dp))
                            Text("This starter app does not yet control Clash of Clans. Game automation requires further implementation and device testing.", color = Color(0xFFCBD5E1), modifier = Modifier.padding(top = 14.dp))
                        }
                    }
                    Button(onClick = { running = !running }, modifier = Modifier.fillMaxWidth().padding(top = 22.dp)) {
                        Text(if (running) "Stop demo" else "Start demo")
                    }
                    Text("Build: 1.0.0 • Android 8+", color = Color.Gray, modifier = Modifier.padding(top = 24.dp), fontSize = 12.sp)
                }
            }
        }
    }
}
