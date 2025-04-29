package com.example.peerbuddy.ui.beranda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.peerbuddy.R
import com.example.peerbuddy.model.Banner

class BannerAdapter(private val banners: List<Banner>): RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bannerImage: ImageView = itemView.findViewById(R.id.bannerImage)

        fun bind(banner: Banner) {
            bannerImage.setImageResource(banner.imageResources)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BannerAdapter.BannerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BannerAdapter.BannerViewHolder, position: Int) {
        val banner = banners[position]
        holder.bind(banner)
    }

    override fun getItemCount(): Int = banners.size
}