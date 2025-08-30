package com.example.mediundeliver

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import mediundeliver.composeapp.generated.resources.Res
import mediundeliver.composeapp.generated.resources.delivery_map
import mediundeliver.composeapp.generated.resources.ic_arrow_back
import mediundeliver.composeapp.generated.resources.ic_battery
import mediundeliver.composeapp.generated.resources.ic_location_marker
import mediundeliver.composeapp.generated.resources.ic_location_marker_2
import mediundeliver.composeapp.generated.resources.ic_route_line
import mediundeliver.composeapp.generated.resources.ic_signal
import mediundeliver.composeapp.generated.resources.ic_tab_favorites
import mediundeliver.composeapp.generated.resources.ic_tab_home
import mediundeliver.composeapp.generated.resources.ic_tab_orders
import mediundeliver.composeapp.generated.resources.ic_tab_profile
import mediundeliver.composeapp.generated.resources.ic_tab_search
import mediundeliver.composeapp.generated.resources.ic_timeline_dot
import mediundeliver.composeapp.generated.resources.ic_timeline_dot_active
import mediundeliver.composeapp.generated.resources.ic_wifi

@Composable
@Preview
fun App() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5CB58)) // Yellow background from Figma
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Status Bar
            StatusBar()

            // Main Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 35.dp)
            ) {
                Spacer(modifier = Modifier.height(13.dp))

                // Header with back arrow and title
                HeaderSection()

                Spacer(modifier = Modifier.height(40.dp))

                // Shipping Address section
                ShippingAddressSection()

                Spacer(modifier = Modifier.height(19.dp))

                // Map section with location markers
                MapSection()

                Spacer(modifier = Modifier.height(29.dp))

                // Delivery Time section
                DeliveryTimeSection()

                // Timeline section
                TimelineSection()
            }

            // Bottom action buttons
            BottomActionButtons()

            // Bottom navigation bar
            BottomNavigationBar()
        }
    }
}

// Status Bar Component
@Composable
private fun StatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .padding(horizontal = 35.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "16:04",
            color = Color(0xFF391713),
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif // League Spartan Medium
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_signal),
                contentDescription = "Signal",
                modifier = Modifier.size(13.dp),
                tint = Color(0xFF391713)
            )
            Icon(
                painter = painterResource(Res.drawable.ic_wifi),
                contentDescription = "WiFi",
                modifier = Modifier.size(15.dp),
                tint = Color(0xFF391713)
            )
            Icon(
                painter = painterResource(Res.drawable.ic_battery),
                contentDescription = "Battery",
                modifier = Modifier.size(17.dp),
                tint = Color(0xFF391713)
            )
        }
    }
}

// Header Section with back arrow and title
@Composable
private fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_arrow_back),
            contentDescription = "Back",
            modifier = Modifier.size(8.dp),
            tint = Color(0xFF391713)
        )
        Spacer(modifier = Modifier.width(11.dp))
        Text(
            text = "Delivery time",
            color = Color(0xFFF8F8F8),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif // League Spartan Bold
        )
    }
}

// Shipping Address Section
@Composable
private fun ShippingAddressSection() {
    Column {
        Text(
            text = "Shipping Address",
            color = Color(0xFF391713),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif // League Spartan Bold
        )

        Spacer(modifier = Modifier.height(13.dp))

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
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif, // League Spartan Regular
                modifier = Modifier.padding(horizontal = 11.dp)
            )
        }
    }
}

// Map Section with location markers
@Composable
private fun MapSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(191.dp)
            .clip(RoundedCornerShape(11.dp))
    ) {
        Image(
            painter = painterResource(Res.drawable.delivery_map),
            contentDescription = "Map",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Route line - positioned at exact Figma coordinates
        Icon(
            painter = painterResource(Res.drawable.ic_route_line),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 103.dp, y = 45.dp)
                .size(width = 100.dp, height = 68.dp),
            tint = Color(0xFFE95322)
        )

        // Restaurant location marker - positioned at exact Figma coordinates
        Icon(
            painter = painterResource(Res.drawable.ic_location_marker),
            contentDescription = "Restaurant location",
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 89.dp, y = 27.dp)
                .size(20.dp),
            tint = Color.Unspecified
        )

        // Delivery location marker - positioned at exact Figma coordinates
        Icon(
            painter = painterResource(Res.drawable.ic_location_marker_2),
            contentDescription = "Delivery location",
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 201.dp, y = 102.dp)
                .size(23.dp),
            tint = Color.Unspecified
        )
    }
}

// Delivery Time Section
@Composable
private fun DeliveryTimeSection() {
    Column {
        Text(
            text = "Delivery Time",
            color = Color(0xFF391713),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif // League Spartan Medium
        )

        Spacer(modifier = Modifier.height(3.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Estimated Delivery",
                color = Color(0xFF391713),
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.SansSerif // League Spartan Light
            )
            Text(
                text = "25 mins",
                color = Color(0xFFE95322),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif // League Spartan Medium
            )
        }
    }
}

// Timeline Section
@Composable
private fun TimelineSection() {
    val timelineItems = listOf(
        "Your order has been accepted" to "2 min",
        "The restaurant is preparing your order" to "5 min",
        "The delivery is on his way" to "10 min",
        "Your order has been delivered" to "8 min"
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(27.dp))

        timelineItems.forEachIndexed { index, (text, time) ->
            TimelineItem(text, time, index == 0)
            if (index < timelineItems.size - 1) {
                Spacer(modifier = Modifier.height(34.dp))
            }
        }
    }
}

// Timeline Item Component
@Composable
private fun TimelineItem(text: String, time: String, isActive: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        // Timeline dot and line
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(18.dp)
        ) {
            Icon(
                painter = painterResource(
                    if (isActive) Res.drawable.ic_timeline_dot_active
                    else Res.drawable.ic_timeline_dot
                ),
                contentDescription = null,
                modifier = Modifier.size(6.dp),
                tint = Color.Unspecified
            )
        }

        Spacer(modifier = Modifier.width(18.dp))

        // Content
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = text,
                color = Color(0xFF391713),
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.SansSerif, // League Spartan Light
                lineHeight = 14.sp
            )
        }

        // Time
        Text(
            text = time,
            color = Color(0xFF391713),
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.SansSerif, // League Spartan Light
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

// Bottom Action Buttons
@Composable
private fun BottomActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        ActionButton("Return Home", filled = false, modifier = Modifier.weight(1f))
        ActionButton("Track Order", filled = true, modifier = Modifier.weight(1f))
    }
}

// Action Button Component
@Composable
private fun ActionButton(text: String, filled: Boolean, modifier: Modifier = Modifier) {
    val backgroundColor = if (filled) Color(0xFFE95322) else Color(0xFFFFDECF)
    val textColor = if (filled) Color.White else Color(0xFFE95322)
    val fontWeight = if (filled) FontWeight.Medium else FontWeight.Normal

    Box(
        modifier = modifier
            .height(34.dp)
            .clip(RoundedCornerShape(38.dp))
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 21.sp,
            fontWeight = fontWeight,
            fontFamily = FontFamily.SansSerif // League Spartan Medium/Normal
        )
    }
}

// Bottom Navigation Bar
@Composable
private fun BottomNavigationBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(61.dp)
            .background(
                Color(0xFFE95322),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(horizontal = 39.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigationIcon(Res.drawable.ic_tab_home)
            NavigationIcon(Res.drawable.ic_tab_search)
            NavigationIcon(Res.drawable.ic_tab_orders)
            NavigationIcon(Res.drawable.ic_tab_favorites)
            NavigationIcon(Res.drawable.ic_tab_profile)
        }
    }
}

// Navigation Icon Component
@Composable
private fun NavigationIcon(resource: DrawableResource) {
    Icon(
        painter = painterResource(resource),
        contentDescription = null,
        modifier = Modifier.size(24.dp),
        tint = Color.White
    )
}