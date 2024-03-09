import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aviatickets.R
import com.example.aviatickets.databinding.ItemOfferBinding
import com.example.aviatickets.model.entity.Offer

class OfferListAdapter : RecyclerView.Adapter<OfferListAdapter.ViewHolder>() {

    private var items: List<Offer> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOfferBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateList(newList: List<Offer>) {
        val diffResult = DiffUtil.calculateDiff(OfferDiffCallback(items, newList))
        items = newList
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ItemOfferBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(offer: Offer) {
            // Здесь привязываем данные к представлению
            val flight = offer.flight

//            with(binding) {
//                // Загрузка изображения с помощью Glide
//                Glide.with(itemView)
//                    .load(offer.airline.logoUrl) // Предполагается, что в Offer есть ссылка на логотип авиакомпании
//                    .into(airlineLogo)
//
//                departureTime.text = flight.departureTimeInfo
//                arrivalTime.text = flight.arrivalTimeInfo
//                route.text = context.getString(
//                    R.string.route_fmt,
//                    flight.departureLocation.code,
//                    flight.arrivalLocation.code
//                )
//                duration.text = context.getString(
//                    R.string.time_fmt,
//                    getTimeFormat(flight.duration).first.toString(),
//                    getTimeFormat(flight.duration).second.toString()
//                )
//                direct.text = context.getString(R.string.direct)
//                price.text = context.getString(R.string.price_fmt, offer.price.toString())
//            }
        }
    }

    // Класс для вычисления разницы между списками
    private class OfferDiffCallback(private val oldList: List<Offer>, private val newList: List<Offer>) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
    private fun getTimeFormat(minutes: Int): Pair<Int, Int> {
        val hours = minutes / 60
        val remainingMinutes = minutes % 60
        return Pair(hours, remainingMinutes)
    }
}
