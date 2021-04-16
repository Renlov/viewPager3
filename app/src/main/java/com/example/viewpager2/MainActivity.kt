package com.example.viewpager2

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.annotation.Dimension.PX
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs


class MainActivity : FragmentActivity() {
    private lateinit var arrayList: ArrayList<Item>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayList = arrayListOf(
            Item("Packet - 5 nudes", "3 $"),
            Item("Packet - 20 nudes", "20 $"),
            Item("Packet - 100 nudes", "120 $"),
        )
        val pager: ViewPager2 = findViewById(R.id.pager)
        val adapter = Adapter(arrayList, applicationContext)
        pager.adapter = adapter
        pager.setPadding(120, 0, 120, 0)
        pager.offscreenPageLimit = 3


        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
            page.scaleX = 1 - (0.25f * kotlin.math.abs(position))
        }
        pager.setPageTransformer(pageTransformer)
        pager.clipToPadding = true
        pager.clipChildren = true
        pager.currentItem = 1
    }

}