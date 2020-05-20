package YOUTUBE;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    public void map(LongWritable key,Text values,Context context)throws IOException,InterruptedException {
        youtube you = new youtube();
        String []split = values.toString().split(",");
        you.setVideoId(Integer.parseInt(split[0]));
        you.setUploader(split[1]);
        you.setCategory(split[2]);
        you.setLength(Integer.parseInt(split[3]));
        you.setView(Integer.parseInt(split[4]));
        you.setComments(Integer.parseInt(split[5]));
        //find out top5 categories with maximum number of video uploaded;
        context.write(new Text(you.getCategory()),new IntWritable(1));

    }
}
