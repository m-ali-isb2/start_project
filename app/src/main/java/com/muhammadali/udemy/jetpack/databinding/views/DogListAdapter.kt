package com.muhammadali.udemy.jetpack.databinding.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.muhammadali.udemy.jetpack.databinding.R
import com.muhammadali.udemy.jetpack.databinding.databinding.ItemDogBinding
import com.muhammadali.udemy.jetpack.databinding.model.DogBreed
import com.muhammadali.udemy.jetpack.databinding.utils.getProgressDrawable
import com.muhammadali.udemy.jetpack.databinding.utils.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

/**
 * Created by Muhammad Ali on 29-Apr-20.
 * Email muhammad.ali9385@gmail.com
 */
class DogListAdapter(val dogBreedList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogListAdapter.DogViewHolder>(), DogClickListeners {

    var view: ItemDogBinding? = null

    inner class DogViewHolder(var view: ItemDogBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        view = DataBindingUtil.inflate<ItemDogBinding>(inflater, R.layout.item_dog, parent, false)
        return DogViewHolder(view!!)
    }

    override fun getItemCount(): Int = dogBreedList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.dog = dogBreedList[position]
        holder.view.dogListener = this
     /*    holder.view.name.text = dogBreedList.get(position).breed
         holder.view.body.text = dogBreedList.get(position).lifespan
         holder.view.setOnClickListener {
             val action =
                 ListFragmentDirections.actionListFragmentToDetailFragment(dogBreedList[position].uuid.toLong())
             Navigation.findNavController(it)
                 .navigate(action)
         }

         holder.view.image.loadImage(
             dogBreedList[position].image,
             getProgressDrawable(holder.view.image.context)
         )*/
    }

    fun updateDogList(dogBreedList: ArrayList<DogBreed>) {
        this.dogBreedList.clear()
        this.dogBreedList.addAll(dogBreedList)
        notifyDataSetChanged()
    }

    /* override fun onClick(view: View) {

     }*/

    override fun onClick(view :View,dogBreed: DogBreed) {
        val action =
            ListFragmentDirections.actionListFragmentToDetailFragment(dogBreed.id)
        Navigation.findNavController(view)
            .navigate(action)
    }
}