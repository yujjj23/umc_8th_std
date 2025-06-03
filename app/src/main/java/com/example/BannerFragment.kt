package com.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.test.R

class BannerFragment : Fragment() {
    companion object {
        private const val ARG_IMAGE = "image"
        fun newInstance(image: String) = BannerFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_IMAGE, image)
            }
        }
    }

    private var imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageUrl = arguments?.getString(ARG_IMAGE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val imageView = ImageView(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            scaleType = ImageView.ScaleType.CENTER_CROP
            // Glide or Picasso 같은 라이브러리로 이미지 로드 추천
            // Glide.with(this).load(imageUrl).into(this)
            setImageResource(R.drawable.vlzmalsdldi) // 테스트용 기본 이미지
        }
        return imageView
    }
}
