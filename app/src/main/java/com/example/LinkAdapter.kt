package com.example

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ItemLibraryLinkBinding

class LinkAdapter(private val links: MutableList<String>) : RecyclerView.Adapter<LinkAdapter.LinkViewHolder>() {

    inner class LinkViewHolder(val binding: ItemLibraryLinkBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnDelete.setOnClickListener {
                AlertDialog.Builder(binding.root.context)
                    .setMessage("삭제하시겠습니까?")
                    .setPositiveButton("예") { _, _ ->
                        val pos = adapterPosition
                        if (pos != RecyclerView.NO_POSITION) {
                            links.removeAt(pos)
                            notifyItemRemoved(pos)
                        }
                    }
                    .setNegativeButton("아니오", null)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkViewHolder {
        val binding = ItemLibraryLinkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LinkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LinkViewHolder, position: Int) {
        holder.binding.tvLink.text = links[position]
    }

    override fun getItemCount() = links.size
}
