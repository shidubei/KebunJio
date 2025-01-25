import React from "react";
import {Link} from "react-router-dom"

function MenuSidebar(){
    return(
        <div>
            <div>
                <p>Menu</p>
            </div>
            <div>
                <Link to="/forum/top">Top post</Link>
            </div>
            <div>
                <Link to="/forum/search">Search</Link>
            </div>
            <div>
                <Link to="/forum/new">New post</Link>
            </div>
            <div>
                <Link to="/forum/my">My posts</Link>
            </div>
        </div>

    )
}

export default MenuSidebar;