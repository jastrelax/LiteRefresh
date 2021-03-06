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
package literefresh.sample.ui.viewholder

import android.text.TextUtils
import android.view.View
import literefresh.sample.R
import literefresh.sample.base.ui.BaseViewHolder
import literefresh.sample.base.ui.ViewBinder
import literefresh.sample.common.image.GlideApp
import literefresh.sample.data.remote.TheMovieDbApi.Companion.IMAGE_BASE_URL
import literefresh.sample.data.remote.TheMovieDbApi.Companion.IMAGE_SIZE
import literefresh.sample.data.remote.dto.ResMoviePage
import literefresh.sample.data.remote.dto.ResTrendingPage
import literefresh.sample.databinding.ViewHolderMovieBinding

@ViewBinder(value = R.layout.view_holder_movie, dataTypes = [ResMoviePage.ResultsBean::class, ResTrendingPage.ResultsBean::class])
class MovieViewHolder(itemView: View?) : BaseViewHolder<ViewHolderMovieBinding>(itemView) {
    override fun <T> onBind(data: T, position: Int) {
        if (data is ResMoviePage.ResultsBean) {
            val result = data as ResMoviePage.ResultsBean
            binding!!.tvTitle.text = result.title
            binding!!.tvOverview.text = result.overview
            GlideApp.with(itemView)
                    .load(IMAGE_BASE_URL +
                            IMAGE_SIZE +
                            result.posterPath)
                    .into(binding!!.ivPost)
        }
        if (data is ResTrendingPage.ResultsBean) {
            val result = data as ResTrendingPage.ResultsBean
            binding!!.tvTitle.text = if (TextUtils.isEmpty(result.title)) result.name else result.title
            binding!!.tvOverview.text = result.overview
            GlideApp.with(itemView)
                    .load(IMAGE_BASE_URL +
                            IMAGE_SIZE +
                            result.posterPath)
                    .into(binding!!.ivPost)
        }
    }
}