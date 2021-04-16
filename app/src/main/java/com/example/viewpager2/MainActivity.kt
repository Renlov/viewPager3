package com.example.viewpager2

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3


class MainActivity : FragmentActivity() {
    private lateinit var arrayList:ArrayList<Item>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayList = arrayListOf(
            Item(R.drawable.image, "Uploading a photo"),
            Item(R.drawable.image2, "Return a nude photo")
        )
        val pager: ViewPager2 = findViewById(R.id.pager)
        val adapter = Adapter(arrayList, applicationContext)
        pager.adapter = adapter

        val indicator: CircleIndicator3 = findViewById(R.id.indicator)
        indicator.setViewPager(pager)
    }
}