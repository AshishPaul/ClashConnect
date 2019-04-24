//package com.example.ui.components
//
//import android.support.annotation.IntDef
//import android.support.v7.widget.RecyclerView
//import android.view.ViewGroup
//import com.example.utils.exception.BaseException
//import java.util.*
//
//
//abstract class BaseRecyclerAdapter<T> protected constructor(
//    protected val listItemClickListener: ListItemClickListener<T>,
//    protected val emptyViewClickListener: EmptyViewClickListener
//) : RecyclerView.Adapter<BaseViewHolder>() {
//    @ListState
//    @get:ListState
//    var currentListState = EMPTY_LOADING
//        private set
//    protected var list: MutableList<T>? = null
//    private var scrollAnimator: ScrollAnimator? = null
//    private var error: BaseException? = null
//
//    init {
//        changeState(true)
//    }
//
//    fun setScrollAnimator(itemAnimator: ScrollAnimator) {
//        this.scrollAnimator = itemAnimator
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
//        val holder = getViewHolder(parent, viewType)
//        if (scrollAnimator != null && viewType == NORMAL) {
//            scrollAnimator!!.runEnterAnimation(holder.itemView)
//        }
//        return holder
//    }
//
//    protected abstract fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder
//
//    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
//        onBindViewHolder(holder, position, getItem(position))
//    }
//
//    protected abstract fun onBindViewHolder(holder: BaseViewHolder, position: Int, itemData: T?)
//
//    fun setData(_list: MutableList<T>) {
//        this.list = _list
//        changeState(false)
//        this.notifyDataSetChanged()
//    }
//
//    fun showRetryView(error: BaseException) {
//        //reset existing list data if any.
//        if (list != null) {
//            list!!.clear()
//            list = null
//        }
//        this.error = error
//        changeState(false)
//        this.notifyDataSetChanged()
//    }
//
//    /**
//     * Change current state of the adapter i.e. does it contain data or should it show initial empty loading or should it show retry view.
//     *
//     *
//     * Must notify adapter about this change after calling this method for this change to take effect.
//     *
//     * @param shouldReset if true, current state will be set to [BaseRecyclerAdapter.EMPTY_LOADING]
//     */
//    private fun changeState(shouldReset: Boolean) {
//        if (shouldReset) {
//            currentListState = EMPTY_LOADING
//            return
//        }
//        currentListState = if (list != null && list!!.size > 0) NORMAL else EMPTY_RETRY
//    }
//
//    fun addData(item: T) {
//        if (list == null) {
//            list = ArrayList()
//        }
//
//        list!!.add(item)
//        notifyItemInserted(list!!.size - 1)
//    }
//
//    fun removeData(position: Int) {
//        if (list != null && position < list!!.size) {
//            list!!.removeAt(position)
//            notifyItemRemoved(position)
//        }
//    }
//
//    fun removeData(item: T) {
//        if (list != null && list!!.contains(item)) {
//            val position = list!!.indexOf(item)
//            list!!.remove(item)
//            notifyItemRemoved(position)
//        }
//    }
//
//
//    fun getItem(position: Int): T? {
//        return if (list != null && position < list!!.size) {
//            list!![position]
//        } else null
//    }
//
//    override fun getItemCount(): Int {
//        return if (list == null) 0 else list!!.size
//    }
//
//
//    @IntDef(
//        EMPTY_LOADING,
//        EMPTY_RETRY,
//        NORMAL
//    )
//    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
//    annotation class ListState
//
//    companion object {
//        const val NORMAL = 1
//        const val EMPTY_LOADING = -1
//        const val EMPTY_RETRY = 0
//    }
//
//}
