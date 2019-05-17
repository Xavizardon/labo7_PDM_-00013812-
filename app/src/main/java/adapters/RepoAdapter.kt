package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import kotlinx.android.synthetic.main.repo_cardview.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.room.entities.GithubRepo
import com.example.room.R

class RepoAdapter(var repos:List<GithubRepo>): RecyclerView.Adapter<RepoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.repo_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(holder: RepoAdapter.ViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(repo:GithubRepo)= with(itemView){
            this.tv_repo_name.text=repo.name
        }
    }

}