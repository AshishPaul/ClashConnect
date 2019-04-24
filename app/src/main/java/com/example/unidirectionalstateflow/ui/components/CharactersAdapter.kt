//package com.example.a40002778.myapplication.ui.components
//
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.example.a40002778.myapplication.R
//import com.example.Clan
//
//
//class CharactersAdapter(
//    listItemClickListener: ListItemClickListener<Clan>,
//    emptyViewClickListener: EmptyViewClickListener
//) : BaseRecyclerAdapter<Clan>(listItemClickListener, emptyViewClickListener) {
//
//    override fun getViewHolder(parent: ViewGroup, @ListState viewType: Int): BaseViewHolder {
//        val viewHolder: BaseViewHolder
//        val itemView: View
//        //        switch (viewType) {
//        //            case NORMAL:
//        //                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_character,
//        //                        parent, false);
//        //                viewHolder = new CharacterViewHolder(itemView, listItemClickListener);
//        //                break;
//        //            case EMPTY_LOADING:
//        //                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.loading_view,
//        //                        parent, false);
//        //                viewHolder = new LoadingViewHolder(itemView);
//        //                break;
//        //            case EMPTY_RETRY:
//        //            default:
//        //                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_view,
//        //                        parent, false);
//        //                viewHolder = new EmptyViewHolder(itemView, error, emptyViewClickListener);
//        //        }
//        return null
//    }
//
//    override fun onBindViewHolder(holder: BaseViewHolder, position: Int, itemData: Clan?) {
//
//    }
//
//    @ListState
//    override fun getItemViewType(position: Int): Int {
//        return currentListState
//    }
//
//    override fun getItemCount(): Int {
//        return if (list != null && list!!.size > 0) {
//            list!!.size
//        } else {
//            1
//        }
//    }
//
//
//    internal class CharacterViewHolder(itemView: View, private val listener: ListItemClickListener<Clan>) :
//        BaseViewHolder(itemView) {
//
//
//        override fun onBind(position: Int) {
//
//        }
//    }
//
//}
