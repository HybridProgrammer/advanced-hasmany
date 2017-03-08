package advanced.hasmany

class User {

    static constraints = {
        likePosts minSize: 1
        dislikedPosts minSize: 1
    }

    static hasMany = [likePosts: Post, dislikedPosts: Post]
    List likePosts = new ArrayList()
    List dislikedPosts = new ArrayList()
}
