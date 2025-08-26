package com.example.mediundeliver

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import mediundeliver.composeapp.generated.resources.Res
import mediundeliver.composeapp.generated.resources.compose_multiplatform
import mediundeliver.composeapp.generated.resources.ic_back_chevron
import mediundeliver.composeapp.generated.resources.ic_pin_outline
import mediundeliver.composeapp.generated.resources.ic_tab_favorites
import mediundeliver.composeapp.generated.resources.ic_tab_home
import mediundeliver.composeapp.generated.resources.ic_tab_orders
import mediundeliver.composeapp.generated.resources.ic_tab_profile
import mediundeliver.composeapp.generated.resources.ic_tab_search
import mediundeliver.composeapp.generated.resources.map_07

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F8F8))
        ) {
            Box(Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 24.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                // Top bar
                Row(verticalAlignment = Alignment.CenterVertically) {
                    SmallIcon(resource = Res.drawable.ic_back_chevron)
                    Spacer(Modifier.width(16.dp))
                    Text(
                        text = "Delivery time",
                        color = Color(0xFFF8F8F8),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(Modifier.height(24.dp))

                Text(
                    text = "Shipping Address",
                    color = Color(0xFF391713),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFFF3E9B5)),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = "778 Locust View Drive Oaklanda, CA",
                        color = Color(0xFF391713),
                        fontSize = 16.sp,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                }

                Spacer(Modifier.height(24.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(191.dp)
                        .clip(RoundedCornerShape(11.dp))
                        .background(Color.Transparent),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.map_07),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(Modifier.height(24.dp))

                Text(
                    text = "Delivery Time",
                    color = Color(0xFF391713),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Estimated Delivery",
                        color = Color(0xFF391713),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = "25 mins",
                        color = Color(0xFFE95322),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(Modifier.height(16.dp))

                // Timeline items
                TimelineItem("Your order has been accepted", "2 min")
                Spacer(Modifier.height(12.dp))
                TimelineItem("The restaurant is preparing your order", "5 min")
                Spacer(Modifier.height(12.dp))
                TimelineItem("The delivery is on his way", "10 min")
                Spacer(Modifier.height(12.dp))
                TimelineItem("Your order has been delivered", "8 min")

                Spacer(Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PillButton(text = "Return Home", filled = false)
                    PillButton(text = "Track Order", filled = true)
                }
                }

                // Frame 56 bottom bar overlay
                BottomBarFrame(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun SmallIcon(resource: DrawableResource) {
    Image(
        painter = painterResource(resource),
        contentDescription = null,
        modifier = Modifier.size(20.dp)
    )
}

@Composable
private fun TimelineItem(text: String, time: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(Res.drawable.ic_pin_outline),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = text,
                color = Color(0xFF391713),
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )
        }
        Text(
            text = time,
            color = Color(0xFF391713),
            fontSize = 14.sp,
            fontWeight = FontWeight.Light
        )
    }
}

@Composable
private fun PillButton(text: String, filled: Boolean) {
    val background = if (filled) Color(0xFFE95322) else Color(0xFFFFDECF)
    val content = if (filled) Color(0xFFFFFFFF) else Color(0xFFE95322)
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(46.dp))
            .background(background)
            .height(34.dp)
            .width(140.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = content,
            fontSize = 20.sp,
            fontWeight = if (filled) FontWeight.Medium else FontWeight.Normal
        )
    }
}

@Composable
private fun BottomBarFrame(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(61.dp)
            .background(Color(0xFFE95322))
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomIcon(Res.drawable.ic_tab_home)
            BottomIcon(Res.drawable.ic_tab_search)
            BottomIcon(Res.drawable.ic_tab_orders)
            BottomIcon(Res.drawable.ic_tab_favorites)
            BottomIcon(Res.drawable.ic_tab_profile)
        }
    }
}

@Composable
private fun BottomIcon(resource: DrawableResource) {
    Image(
        painter = painterResource(resource),
        contentDescription = null,
        modifier = Modifier.size(24.dp)
    )
}