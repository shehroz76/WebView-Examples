package testing.demo.app.utils

open class PayloadEvent<out T>(private val content:T) {

    private var hasBeenHandled = false

    /**
     * Returns the content and prevents its use again
     */
    fun handle():T?{
        return if(hasBeenHandled){
            null
        }else{
            hasBeenHandled = true
            content
        }
    }
}

open class Event{
    private var hasBeenHandled = false


    /**
     * Returns the content and prevents its use again
     */
    fun handle():Boolean{
        return if(hasBeenHandled){
            false
        }else{
            hasBeenHandled = true
            true
        }
    }
}


