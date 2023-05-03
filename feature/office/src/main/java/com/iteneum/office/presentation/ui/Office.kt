package com.iteneum.office.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.iteneum.designsystem.components.LPSubTitleLarge
import com.iteneum.designsystem.components.LPTitleLarge
import com.iteneum.designsystem.components.LPTitleMedium
import com.iteneum.designsystem.components.LPTitleSmall
import com.iteneum.designsystem.components.LpOutlinedButton
import com.iteneum.designsystem.theme.LeasePertTheme
import com.iteneum.designsystem.theme.LeasePertTheme.sizes
import com.iteneum.office.R
import com.iteneum.office.presentation.viewmodel.OfficeViewModel

/**
 * This function creates the Office screen UI
 * With the Outlined buttons and the company information
 * @param vm injects the viewModel into the UI
 * @author Yaritza Moreno
 */
@Composable
fun OfficeUI(viewModel: OfficeViewModel = hiltViewModel()) {
    val context = LocalContext.current
    Column(Modifier.fillMaxSize()) {

        //Get sizes from LeasePertTheme archive
        val sizes = LeasePertTheme.sizes
        Text(
            text = stringResource(id = R.string.LPInfo),
            modifier = Modifier
                .width(sizes.extraSize124)
                .height(sizes.regularSize),
            style = TextStyle(
                textAlign = TextAlign.Justify,
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textIndent = TextIndent(firstLine = 14.sp)
            )
        )

        Text(
            text = stringResource(id = R.string.LPAddress),
            style = TextStyle(
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp,
                textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp)
            ),
            modifier = Modifier.padding(top = sizes.extraSize10)
        )

        Text(
            text = stringResource(id = R.string.LPHours),
            modifier = Modifier.padding(top = sizes.extraSize10),
            style = TextStyle(
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp,
                textIndent = TextIndent(firstLine = 14.sp, restLine = 3.sp)
            )
        )

        var phone = stringResource(R.string.LPphoneServiceContact)
        LpOutlinedButton(modifier = Modifier,
            icon = Icons.Filled.Call,
            textButton = stringResource(id = R.string.LPCallButton),
            onClicked = {
                viewModel.makeCall(phone)
            })

        var Email = stringResource(R.string.LPcontactEmail)
        LpOutlinedButton(modifier = Modifier,
            icon = Icons.Outlined.Mail,
            textButton = stringResource(id = R.string.LPMailButton),
            onClicked = {
                viewModel.sendEmail(
                    Email,
                    "mail test",
                    "this is a mail send test",
                )
            })
    }
}
