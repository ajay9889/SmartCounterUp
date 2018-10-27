#include <jni.h>
#include <string>


static jint counter = 0;
extern "C"
JNIEXPORT jint JNICALL
Java_test_android_ndk_counter_MainActivity_resetFromJNI(JNIEnv *env, jobject instance) {
    // TODO
    counter = 0;
    return counter;
}

extern "C"
JNIEXPORT jint JNICALL
Java_test_android_ndk_counter_MainActivity_counterFromJNI(JNIEnv *env, jobject instance) {
    // TODO
    counter+=1;
    return counter;
}
