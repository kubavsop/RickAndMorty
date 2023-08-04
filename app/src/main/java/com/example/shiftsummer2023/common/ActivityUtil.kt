package com.example.shiftsummer2023.common

import androidx.fragment.app.Fragment
import com.example.shiftsummer2023.presentation.MainActivity

val Fragment.mainActivity: MainActivity
    get() = requireActivity() as MainActivity