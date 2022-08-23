package com.example.myrecyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myrecyclerview.databinding.UserDetailBinding

class UserDetail : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "EXTRA_DATA"
    }
    private lateinit var detailBinding: UserDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = UserDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val hero = intent.getParcelableExtra<Hero>(EXTRA_DATA)

        detailBinding.apply{
            detailName.text = "Nama: ${hero?.name}"
            detailUsername.text = hero?.username
            detailLocation.text = hero?.location
            detailCompany.text =  "Asal: ${hero?.company}"
            detailFollowers.text = "Suhu: ${hero?.followers} F"
            detailFollowing.text = "Cahaya: ${hero?.following} fc"
        }
        Glide.with(this)
            .load(hero?.img)
//            .apply(RequestOptions.circleCropTransform())
            .into(detailBinding.detailImg)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = hero?.username
            elevation = 0f
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}

