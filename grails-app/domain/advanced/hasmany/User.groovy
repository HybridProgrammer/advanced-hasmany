package advanced.hasmany

class User {

    static constraints = {
        likePosts minSize: 1
        dislikedPosts minSize: 1
    }

//    static mappedBy = [likePosts: "none", dislikedPosts: "none"]

    static mapping = {
        likePosts joinTable: "user_post_like"
        dislikedPosts joinTable: "user_post_dislike"
    }

    static hasMany = [likePosts: Post, dislikedPosts: Post]
    List likePosts = new ArrayList()
    List dislikedPosts = new ArrayList()
}
