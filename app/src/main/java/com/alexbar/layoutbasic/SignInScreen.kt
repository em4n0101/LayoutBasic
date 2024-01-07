package com.alexbar.layoutbasic

// Compose Foundation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape

// Compose Material Components
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff

// Compose Material3 Components
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

// Compose Runtime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// Compose UI
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

// Constraint Layout
import androidx.constraintlayout.compose.ConstraintLayout

// Project-Specific Imports
import com.alexbar.layoutbasic.ui.theme.BackgroundColorGradientEnd
import com.alexbar.layoutbasic.ui.theme.BackgroundColorGradientStart
import com.alexbar.layoutbasic.ui.theme.Dimens
import com.alexbar.layoutbasic.ui.theme.Typography
import java.util.regex.Pattern

@Composable
fun LoginScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val isValidEmail = remember(email) { validateEmail(email) }
    val isValidPassword = remember(password) { validatePassword(password) }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (backgroundBox, backgroundDataBox, helloText, welcomeText, optionsIcon,
            emailTextField, passwordTextField, forgotPasswordText, signInButton,
            doNotHaveAccountText, signUpText
        ) = createRefs()

        Box(modifier = Modifier
            .fillMaxSize()
            .background(createHorizontalGradient())
            .constrainAs(backgroundBox) {}
        )

        Text(
            text = "Hello",
            style = Typography.titleLarge,
            modifier = Modifier
                .padding(start = Dimens.sign_in_padding_32)
                .constrainAs(helloText) {
                    top.linkTo(parent.top, Dimens.sign_in_constraint_40)
                }
        )

        Text(
            text = "Sign in!",
            style = Typography.titleLarge,
            modifier = Modifier
                .padding(start = Dimens.sign_in_padding_32)
                .constrainAs(welcomeText) {
                    top.linkTo(helloText.bottom, Dimens.sign_in_constraint_8)
                }
        )

        Icon(
            imageVector = Icons.Default.MoreHoriz,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .padding(end = Dimens.sign_in_padding_32)
                .size(Dimens.sign_in_icon_more_size)
                .constrainAs(optionsIcon) {
                    top.linkTo(parent.top, Dimens.sign_in_constraint_40)
                    end.linkTo(parent.end)
                }
        )

        val topGuideline = createGuidelineFromTop(Dimens.sign_in_top_guideline)

        Surface(
            color = Color.White,
            shape = RoundedCornerShape(Dimens.sign_in_rounded_corner_shape),
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(backgroundDataBox) {
                    top.linkTo(topGuideline)
                }
        ) {}

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Email icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.sign_in_padding_32)
                .constrainAs(emailTextField) {
                    top.linkTo(backgroundDataBox.top, Dimens.sign_in_constraint_40)
                }
            ,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.sign_in_padding_32)
                .constrainAs(passwordTextField) {
                    top.linkTo(emailTextField.bottom, Dimens.sign_in_constraint_24)
                },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            trailingIcon = {
                val image = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(imageVector = image, contentDescription = "Icon password visibility")
                }
            }
        )

        Text(
            text = "Forgot password?",
            style = Typography.bodyLarge,
            modifier = Modifier
                .constrainAs(forgotPasswordText) {
                    top.linkTo(passwordTextField.bottom, Dimens.sign_in_constraint_24)
                    end.linkTo(passwordTextField.end, Dimens.sign_in_padding_32)
                }
        )

        val buttonGuideline = createGuidelineFromTop(Dimens.sign_in_button_guideline)
        Button(
            enabled = (isValidEmail && isValidPassword),
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.sign_in_button_height_55)
                .padding(horizontal = Dimens.sign_in_padding_32)
                .constrainAs(signInButton) {
                    top.linkTo(buttonGuideline)
                },
            onClick = { }
        ) {
            Text(
                text = "SIGN IN",
                style = Typography.titleSmall
            )
        }

        Text(
            text = "Don't have account?",
            modifier = Modifier
                .constrainAs(doNotHaveAccountText) {
                    bottom.linkTo(signUpText.top, Dimens.sign_in_constraint_8)
                    end.linkTo(passwordTextField.end, Dimens.sign_in_padding_32)
                }
        )

        Text(
            text = "Sign up",
            style = Typography.bodyLarge,
            modifier = Modifier
                .constrainAs(signUpText) {
                    bottom.linkTo(parent.bottom, Dimens.sign_in_constraint_24)
                    end.linkTo(parent.end, Dimens.sign_in_padding_32)
                }
        )
    }
}

fun createHorizontalGradient(): Brush = Brush.horizontalGradient(
    colors = listOf(
        BackgroundColorGradientStart,
        BackgroundColorGradientEnd,
    ),
    startX = Dimens.sign_in_background_gradient_start_x
)

private fun validateEmail(email: String): Boolean {
    val emailPattern = Pattern.compile(
        "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    )
    return emailPattern.matcher(email).matches()
}

private fun validatePassword(password: String): Boolean {
    val hasValidLength = password.length > 6
    val hasNumber = password.any { it.isDigit() }
    return hasValidLength && hasNumber
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}