package com.alexbar.layoutbasic

// Compose Foundation
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

// Compose Material Components
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.SportsMartialArts

// Compose Material3 Components
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

// Compose Runtime
import androidx.compose.runtime.Composable

// Compose UI
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

// Constraint Layout
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

// Project-Specific Imports
import com.alexbar.layoutbasic.ui.theme.Dimens
import com.alexbar.layoutbasic.ui.theme.Typography

@Composable
fun WelcomeScreen() {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (backgroundBox, optionsIcon, gymIcon, gymText, welcomeText,
            signInButton, signUpButton, buttonsContainer,
            socialMediaText, instagramIcon, twitterIcon, facebookIcon
        ) = createRefs()

        Box(modifier = Modifier
            .fillMaxSize()
            .background(createHorizontalGradient())
            .constrainAs(backgroundBox) {}
        )

        Icon(
            imageVector = Icons.Default.MoreHoriz,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .padding(end = Dimens.sign_up_padding_32)
                .size(Dimens.sign_up_icon_more_size)
                .constrainAs(optionsIcon) {
                    top.linkTo(parent.top, Dimens.sign_up_constraint_40)
                    end.linkTo(parent.end)
                }
        )

        val topGuideline = createGuidelineFromTop(Dimens.sign_up_top_guideline)

        Icon(
            imageVector = Icons.Default.SportsMartialArts,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(Dimens.sign_up_icon_gym_size)
                .constrainAs(gymIcon) {
                    top.linkTo(topGuideline)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        )

        Text(
            text = "FITNESS CLUB",
            style = Typography.titleLarge,
            modifier = Modifier
                .constrainAs(gymText) {
                    top.linkTo(gymIcon.bottom, Dimens.sign_up_constraint_24)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        )

        ConstraintLayout(modifier = Modifier.constrainAs(buttonsContainer) {
            top.linkTo(gymText.bottom, Dimens.sign_up_constraint_70)
            bottom.linkTo(socialMediaText.top, Dimens.sign_up_constraint_70)
            height = Dimension.fillToConstraints
        }) {
            Text(
                text = "Welcome Back",
                style = Typography.titleLarge,
                modifier = Modifier
                    .constrainAs(welcomeText) {
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    }
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.sign_up_button_height_55)
                    .padding(horizontal = Dimens.sign_up_padding_32)
                    .constrainAs(signInButton) {
                    },
                onClick = { }
            ) {
                Text(
                    text = "SIGN IN",
                    style = Typography.titleSmall
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.sign_up_button_height_55)
                    .padding(horizontal = Dimens.sign_up_padding_32)
                    .constrainAs(signUpButton) {
                    },
                onClick = { }
            ) {
                Text(
                    text = "SIGN IN",
                    style = Typography.titleSmall
                )
            }
            createVerticalChain(welcomeText, signInButton, signUpButton, chainStyle = ChainStyle.Spread)

        }


        Text(
            text = "Login with Social Media",
            style = Typography.titleSmall,
            color = Color.White,
            modifier = Modifier
                .constrainAs(socialMediaText) {
                    bottom.linkTo(facebookIcon.top, Dimens.sign_up_constraint_16)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.facebook_icon),
            contentDescription = null,
            modifier = Modifier
                .padding(end = Dimens.sign_up_padding_32)
                .size(Dimens.sign_up_icon_social_network)
                .constrainAs(facebookIcon) {
                    bottom.linkTo(parent.bottom, Dimens.sign_up_constraint_40)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.instagram_icon),
            contentDescription = null,
            modifier = Modifier
                .padding(end = Dimens.sign_up_padding_32)
                .size(Dimens.sign_up_icon_social_network)
                .constrainAs(instagramIcon) {
                    bottom.linkTo(parent.bottom, Dimens.sign_up_constraint_40)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.twitter_icon),
            contentDescription = null,
            modifier = Modifier
                .padding(end = Dimens.sign_up_padding_32)
                .size(Dimens.sign_up_icon_social_network)
                .constrainAs(twitterIcon) {
                    bottom.linkTo(parent.bottom, Dimens.sign_up_constraint_40)
                }
        )
        createHorizontalChain(instagramIcon, twitterIcon, facebookIcon, chainStyle = ChainStyle.Packed)
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}