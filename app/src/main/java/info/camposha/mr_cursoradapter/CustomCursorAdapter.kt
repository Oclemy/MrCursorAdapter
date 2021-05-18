package info.camposha.mr_cursoradapter

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView

class CustomCursorAdapter(context: Context, c: Cursor?, autoRequery: Boolean) :
    CursorAdapter(context, c, autoRequery) {
    private var mInflater: LayoutInflater? = null

    private inner class ViewHolder {
        var name: TextView? = null
        var age: TextView? = null
    }

    override fun newView(context: Context, cursor: Cursor, parent: ViewGroup): View {
        val view = mInflater!!.inflate(R.layout.list_item, null)
        val viewHolder = ViewHolder()
        viewHolder.name = view.findViewById<View>(R.id.list_item_name) as TextView
        viewHolder.age = view.findViewById<View>(R.id.list_item_age) as TextView
        view.tag = viewHolder
        return view
    }

    override fun bindView(view: View, context: Context, cursor: Cursor) {
        val viewHolder = view.tag as ViewHolder
        val name = cursor.getString(cursor.getColumnIndex("name"))
        val age = cursor.getInt(cursor.getColumnIndex("age")).toString()
        viewHolder.name!!.text = name
        viewHolder.age!!.text = age
    }

    init {
        mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}