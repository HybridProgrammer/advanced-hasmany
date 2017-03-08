import advanced.hasmany.Post
import advanced.hasmany.User
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

/**
 * Copyright 2013 Jason Heithoff
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * User: jason
 * Date: 3/7/17
 * Time: 8:51 PM
 *
 */
@Integration
@Rollback
class UserITSpec extends Specification {

    User user1

    def setupData() {
        new Post(title: "Post 1").save(flush: true)
        new Post(title: "Post 2").save(flush: true)

        user1 = new User()
    }

    void "test something"() {
        expect: "fix me"
        true == true
    }


    void "Users must like and dislike at least one post each."() {
        given:
        setupData()

        when:
        user1.addToLikePosts(Post.findByTitle("Post 1"))
        user1.addToDislikedPosts(Post.findByTitle("Post 2"))
        user1.save(flush: true)

        then:
        user1.validate()
        User.count() == 1

    }

}
