package com.example.myfirstkotlinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val BackgroundColor = Color(0xFFF2F2F2)
val PrimaryBlack = Color(0xFF111111)
val SecondaryGray = Color(0xFF6B6B6B)
val CardColor = Color(0xFFFFFFFF)
val DarkSurface = Color(0xFF1C1C1C)

// ======================================
// MainActivity
// ======================================

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                ModernAIScreen()
            }
        }
    }
}

// ======================================
// Main Screen
// ======================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModernAIScreen() {

    Scaffold(
        containerColor = BackgroundColor,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "LiteRT AI Demo",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = PrimaryBlack
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Rounded.MoreVert,
                            contentDescription = null,
                            tint = PrimaryBlack
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor
                )
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BackgroundColor)
                    .navigationBarsPadding()
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BottomNavItem(Icons.Rounded.PhotoCamera, "Capture") {}
                BottomNavItem(Icons.Rounded.Collections, "Gallery") {}
                BottomNavItem(Icons.Rounded.Sync, "Model") {}
                BottomNavItem(Icons.Rounded.Delete, "Clear") {}
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(12.dp))

            // ======================================
            // Camera Preview
            // ======================================

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .background(DarkSurface)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Rounded.CameraAlt,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(72.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Camera Preview",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))


                }

                // status badge
                Surface(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopEnd),
                    color = Color.White.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(50)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(RoundedCornerShape(50))
                                .background(Color(0xFF65E569))
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = "READY",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ======================================
            // Result Card
            // ======================================

            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = CardColor,
                tonalElevation = 1.dp,
                shadowElevation = 2.dp
            ) {
                Column(modifier = Modifier.padding(24.dp)) {

                    Text(
                        text = "Inference Result",
                        color = SecondaryGray,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    // 填充结果数据
                    ResultItem("Model", "MobileNet")
                    Spacer(modifier = Modifier.height(24.dp))
                    ResultItem("Result", "Cat")
                    Spacer(modifier = Modifier.height(24.dp))
                    ResultItem("Confidence", "96.2%")
                    Spacer(modifier = Modifier.height(24.dp))
                    ResultItem("Time", "28 ms")
                }
            }
        }
    }
}

// ======================================
// Result Item
// ======================================


@Composable
fun ResultItem(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween // 标签靠左，值靠右对齐
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            color = SecondaryGray
        )

        Text(
            text = value,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = PrimaryBlack
        )
    }
}

// ======================================
// Bottom Nav Item
// ======================================

@Composable
fun BottomNavItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(70.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = PrimaryBlack.copy(alpha = 0.85f),
            modifier = Modifier.size(26.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            color = SecondaryGray
        )
    }
}

// ======================================
// Preview
// ======================================

@Preview(showBackground = true)
@Composable
fun PreviewUI() {
    MaterialTheme {
        ModernAIScreen()
    }
}