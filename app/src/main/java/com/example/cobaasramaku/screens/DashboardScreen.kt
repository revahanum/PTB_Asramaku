package com.example.cobaasramaku.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cobaasramaku.R
import com.example.cobaasramaku.navigation.Screen
import com.example.cobaasramaku.ui.theme.BackgroundColor
import com.example.cobaasramaku.ui.theme.LightTeal
import com.example.cobaasramaku.ui.theme.PrimaryTeal

@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Logo Asramaku",
                            modifier = Modifier
                                .size(65.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "ASRAMAKU",
                            color = PrimaryTeal,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                actions ={
                    IconButton(onClick = { /*Navigate to Profile*/ }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Profile",
                            tint = PrimaryTeal,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor
                )
            )
        },
        containerColor = BackgroundColor
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Spacer(modifier = Modifier.height(20.dp))

            ModuleButton(
                text = "PEMBAYARAN",
                onClick = { /*Navigate to Pembayaran*/ }
            )

            ModuleButton(
                text = "PELAPORAN\nKERUSAKAN BARANG",
                onClick = { /*Navigate to Pelaporan*/ }
            )

            ModuleButton(
                text = "PIKET",
                onClick = { /*Navigate to Piket*/ }
            )
        }
    }
}

@Composable
fun ModuleButton(
    text: String,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = LightTeal,
            contentColor = PrimaryTeal
        ),
        shape = RoundedCornerShape(16.dp)
    ){
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 22.sp,
            textAlign = TextAlign.Center
        )
    }
}
