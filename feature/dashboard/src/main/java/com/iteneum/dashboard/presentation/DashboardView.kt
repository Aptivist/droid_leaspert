package com.iteneum.dashboard.presentation


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.iteneum.dashboard.R
import com.iteneum.designsystem.components.LPGenericElevatedCard
import com.iteneum.designsystem.components.LpBadgeButton
import com.iteneum.designsystem.components.LpGenericCard
import com.iteneum.designsystem.components.getRandomColor
import com.iteneum.designsystem.theme.LPTypography
import com.iteneum.designsystem.theme.LeasePertTheme
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView() {
    val sizes = LeasePertTheme.sizes
    // TODO mock data, change for real data
    val username = "Martin"
    val badgeNumberNotification = "10"
    val badgeNumberPerson = "20"
    val showBadgeNotification = true
    val showBadgePerson = false
    val currentBalance = "0.00"
    val currentBalanceCurrency = true
    val serviceRequest = "1"
    val amenityReservations = "1"
    val eventList = listOf("Coffee + Donuts", "Pool party", "Discounts")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(sizes.regularSize)
            .verticalScroll(rememberScrollState())
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                text = stringResource(R.string.dashboard_welcome_back, username),
                style = LPTypography.titleMedium,
            )
            LpBadgeButton(
                badgeNumber = badgeNumberNotification,
                showBadge = showBadgeNotification,
                imageVector = Icons.Filled.Notifications
            ) {
                Log.e("tag", "go to notification")
            }
            LpBadgeButton(
                badgeNumber = badgeNumberPerson,
                showBadge = showBadgePerson,
                imageVector = Icons.Filled.Person
            ) {
                Log.e("tag", "go to person")
            }
        }
        Spacer(modifier = Modifier.size(sizes.minorRegularSize))
        LpGenericCard(
            modifier = Modifier
                .fillMaxWidth(),
            title = stringResource(R.string.dashboard_current_balance),
            details = stringResource(R.string.dashboard_go_to_payments),
            accountNumber = currentBalance,
            currency = currentBalanceCurrency
        ) {
            Log.e("tag", "Go to payments")
        }
        Spacer(modifier = Modifier.size(sizes.regularSize))
        LpGenericCard(
            title = stringResource(R.string.dashboard_service_request),
            details = stringResource(R.string.dashboard_view_detail),
            accountNumber = serviceRequest,
        ) {
            Log.e("tag", "go to service request")
        }
        Spacer(modifier = Modifier.size(sizes.regularSize))
        LpGenericCard(
            title = stringResource(R.string.dashboard_amenity_reservations),
            details = stringResource(R.string.dashboard_view_detail),
            accountNumber = amenityReservations
        ) {
            Log.e("tag", "go to amenity reservations")
        }
        Spacer(modifier = Modifier.size(sizes.regularSize))
        Text(
            text = stringResource(R.string.dashboard_happening_today),
            style = LPTypography.titleMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
        LazyRow(
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(eventList) { event ->
                LPGenericElevatedCard(
                    title = event,
                    description = "This is mock data",
                    buttonText = "Go to Screen",
                    color = getRandomColor(Random.nextInt(0, 3))
                ) {
                    Log.e("tag", event)
                }
            }
        }
    }
}