package com.example.kafkademo.model;


public class Topic {

    String topicName;
    int partition;
    short replica;

    public Topic() {
    }

    public Topic(String topicName, int partition, short replica) {
        this.topicName = topicName;
        this.partition = partition;
        this.replica = replica;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public short getReplica() {
        return replica;
    }

    public void setReplica(short replica) {
        this.replica = replica;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicName='" + topicName + '\'' +
                ", partition=" + partition +
                ", replica=" + replica +
                '}';
    }
}
