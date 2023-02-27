package com.drawgestures.learncomposeui.data.models

import androidx.compose.ui.graphics.Color
import com.drawgestures.learncomposeui.ui.theme.HighPriorityColor
import com.drawgestures.learncomposeui.ui.theme.LowPriorityColor
import com.drawgestures.learncomposeui.ui.theme.MediumPriorityColor
import com.drawgestures.learncomposeui.ui.theme.NonePriorityColor

enum class Priority(val color : Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}