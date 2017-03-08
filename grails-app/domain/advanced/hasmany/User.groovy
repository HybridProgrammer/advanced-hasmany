package advanced.hasmany

class User {

    static constraints = {
    }

    static hasMany = [likePosts: Post, dislikedPosts: Post]
}
