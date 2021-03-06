/*
 * Copyright 2018 yinpinjiu@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package literefresh.sample.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import literefresh.sample.R

class SampleAnchoredView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyle: Int = 0) : ConstraintLayout(context, attrs, defStyle) {
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        try {
            val params = layoutParams as CoordinatorLayout.LayoutParams
            params.topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -64f, resources.displayMetrics).toInt()
            layoutParams = params
        } catch (e: ClassCastException) {
        }
    }

    init {
        View.inflate(context, R.layout.view_sample_anchored, this)
    }
}