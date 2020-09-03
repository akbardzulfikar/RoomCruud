package co.id.roomcrud

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import co.id.roomcruud.R
import co.id.roomcruud.databinding.SubscriberListItemBinding
import co.id.roomcrud.db.Subscriber
import co.id.roomcruud.generated.callback.OnClickListener

class SubscriberRecylerViewAdapter(private val clickListener:(Subscriber)->Unit) :
    RecyclerView.Adapter<SubscriberViewHolder>() {

    private val subscribersList = ArrayList<Subscriber>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : SubscriberListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.subscriber_list_item,parent, false)
        return SubscriberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        holder.bind(subscribersList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }

    fun setList(subscriber: List<Subscriber>){
        subscribersList.clear()
        subscribersList.addAll(subscriber)
    }
}

class SubscriberViewHolder(val binding: SubscriberListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(subscriber: Subscriber, clickListener:(Subscriber)->Unit){
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email
        binding.listItemLayout.setOnClickListener{
            clickListener(subscriber)
        }
    }
}