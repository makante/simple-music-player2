package android.SimpleMusicPlayer;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

class Mp3Filter implements FilenameFilter {
    public boolean accept(File dir, String name) {
        return (name.endsWith(".mp3"));
    }
}

public class SimpleMusicPlayer extends ListActivity implements OnClickListener  {
   
	int pos=-1;
	int countSongs=0;

	private static final String MEDIA_PATH = new String("/sdcard/");
	
	private List<String> songs = new ArrayList<String>();
	private MediaPlayer mp = new MediaPlayer();
	
	
	@Override
    public void onCreate(Bundle icicle) {

        	super.onCreate(icicle);
        	setContentView(R.layout.songlist);
        	updateSongList();

        	final Button btnPause=(Button)findViewById(R.id.btnPause);
        	final Button btnContinue=(Button)findViewById(R.id.btnContinue);
        	final Button btnStop=(Button)findViewById(R.id.btnStop);
        	btnStop.setOnClickListener(this);
        	btnContinue.setOnClickListener(this);
        	btnPause.setOnClickListener(this);
        	btnContinue.setEnabled(false);
        	btnPause.setEnabled(false);
        	final Button btnPrevious=(Button)findViewById(R.id.btnPrevious);
        	btnPrevious.setOnClickListener(this);
        	final Button btnNext=(Button)findViewById(R.id.btnNext);
        	btnNext.setOnClickListener(this);
       
    }
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
	    {
	    case R.id.btnContinue :
	    	mp.start();
	    	String itemName=getListView().getItemAtPosition(pos).toString();
	    	final TextView txtNow=(TextView)findViewById(R.id.txtNow);
	    	txtNow.setVisibility(0);
	    	txtNow.setText("Now playing: "+itemName.toString());
	    	final Button btnPause=(Button)findViewById(R.id.btnPause);
		    btnPause.setEnabled(true);
		    final Button btnContinue=(Button)findViewById(R.id.btnContinue);
	    	btnContinue.setEnabled(false);
	    	break;
   	
	    case R.id.btnPause :
	    	mp.pause();
	    	final Button btnPause1=(Button)findViewById(R.id.btnPause);
		    btnPause1.setEnabled(false);
		    final Button btnContinue1=(Button)findViewById(R.id.btnContinue);
	    	btnContinue1.setEnabled(true);
	    	final TextView txtNow1=(TextView)findViewById(R.id.txtNow);
	    	txtNow1.setText("");
	    	break;
	    	
	    case R.id.btnStop :
	    	mp.stop();
            final Button btnContinue11=(Button)findViewById(R.id.btnContinue);
            btnContinue11.setEnabled(false);
            final Button btnPause11=(Button)findViewById(R.id.btnPause);
	    	btnPause11.setEnabled(false);
	    	final Button btnStop=(Button)findViewById(R.id.btnStop);
	    	btnStop.setEnabled(false);
	    	final TextView txtNow11=(TextView)findViewById(R.id.txtNow);
	    	txtNow11.setText("");
	    	final Button btnPrevious=(Button)findViewById(R.id.btnPrevious);
	    	btnPrevious.setEnabled(false);
	    	final Button btnNext=(Button)findViewById(R.id.btnNext);
	    	btnNext.setEnabled(false);
	    	break;
	    	
	    case R.id.btnPrevious :
	    	
		    try 
		    {
		    	pos=pos-1;
		    	mp.reset();
				mp.setDataSource(MEDIA_PATH + songs.get(pos));
				mp.prepare();
			    mp.start();
			    
			    final Button btnContinue111=(Button)findViewById(R.id.btnContinue);
	            btnContinue111.setEnabled(false);
	            final Button btnPause111=(Button)findViewById(R.id.btnPause);
		    	btnPause111.setEnabled(true);
			    
			    String itemName1=getListView().getItemAtPosition(pos).toString();
			    final TextView txtNow111=(TextView)findViewById(R.id.txtNow);
		    	txtNow111.setText("Now playing: "+itemName1.toString());
			    if((pos)==0)
			    {
			    	final Button btnPrevious1=(Button)findViewById(R.id.btnPrevious);
			    	btnPrevious1.setEnabled(false);
			    }
			    if((pos)==(countSongs-1))
		    	{
		    		final Button btnNext1=(Button)findViewById(R.id.btnNext);
			    	btnNext1.setEnabled(false);
		    	}
		    	else
		    	{
		    		final Button btnNext1=(Button)findViewById(R.id.btnNext);
			    	btnNext1.setEnabled(true);
		    	}
		    } 
			 catch (IllegalArgumentException e)
			 {
				// TODO Auto-generated catch block
					e.printStackTrace();
			 }	
			 catch (IllegalStateException e)
			 {
				// TODO Auto-generated catch block
					e.printStackTrace();
			 }		
			 catch (IOException e)
			 {
				// TODO Auto-generated catch block
					e.printStackTrace();
			 }
			 break;
			
	    case R.id.btnNext :
	    	
		    try 
		    {
		    	pos=pos+1;
		    	mp.reset();
				mp.setDataSource(MEDIA_PATH + songs.get(pos));
				mp.prepare();
			    mp.start();
			    
			    final Button btnContinue112=(Button)findViewById(R.id.btnContinue);
	            btnContinue112.setEnabled(false);
	            final Button btnPause112=(Button)findViewById(R.id.btnPause);
		    	btnPause112.setEnabled(true);
			    
			    String itemName1=getListView().getItemAtPosition(pos).toString();
			    final TextView txtNow111=(TextView)findViewById(R.id.txtNow);
		    	txtNow111.setText("Now playing: "+itemName1.toString());
			    if((pos)==(countSongs-1))
			    {
			    	final Button btnNext1=(Button)findViewById(R.id.btnNext);
			    	btnNext1.setEnabled(false);
			    }
			    else
		    	{
		    		final Button btnNext1=(Button)findViewById(R.id.btnNext);
			    	btnNext1.setEnabled(true);
		    	}
			    if((pos)==0 || (pos)==-1)
		    	{
		    		final Button btnPrevious1=(Button)findViewById(R.id.btnPrevious);
			    	btnPrevious1.setEnabled(false);
		    	}
		    	else 
		    	{
		    		final Button btnPrevious1=(Button)findViewById(R.id.btnPrevious);
			    	btnPrevious1.setEnabled(true);
		    	}
		    	
		    } 
			 catch (IllegalArgumentException e)
			 {
				// TODO Auto-generated catch block
					e.printStackTrace();
			 }	
			 catch (IllegalStateException e)
			 {
				// TODO Auto-generated catch block
					e.printStackTrace();
			 }		
			 catch (IOException e)
			 {
				// TODO Auto-generated catch block
					e.printStackTrace();
			 }		
			 break;
		    	    	
	    }
		
	}
    
    public void updateSongList() {
    	File home = new File(MEDIA_PATH);
		if (home.listFiles( new Mp3Filter()).length > 0) {
    		for (File file : home.listFiles( new Mp3Filter())) {
    			songs.add(file.getName());
    		}
		
    		ArrayAdapter<String> songList = new ArrayAdapter<String>(this,R.layout.song_item,songs);
    		setListAdapter(songList);
		}    	
    }

	@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
		
		pos=position;
		countSongs=getListView().getCount();
	
		try 
		{
			final Button btnPause=(Button)findViewById(R.id.btnPause);
	    	btnPause.setEnabled(true);
	    	final Button btnContinue=(Button)findViewById(R.id.btnContinue);
	    	btnContinue.setEnabled(false);
	    	final Button btnStop=(Button)findViewById(R.id.btnStop);
	    	btnStop.setEnabled(true);
	    	
	    	if(pos==0 || pos==-1)
	    	{
	    		final Button btnPrevious=(Button)findViewById(R.id.btnPrevious);
		    	btnPrevious.setEnabled(false);
	    	}
	    	else 
	    	{
	    		final Button btnPrevious=(Button)findViewById(R.id.btnPrevious);
		    	btnPrevious.setEnabled(true);
	    	}
	    	if((pos+1)==countSongs)
	    	{
	    		final Button btnNext=(Button)findViewById(R.id.btnNext);
		    	btnNext.setEnabled(false);
	    	}
	    	else
	    	{
	    		final Button btnNext=(Button)findViewById(R.id.btnNext);
		    	btnNext.setEnabled(true);
	    	}
	    	
	    	//get the name of the song
	    	String itemName=getListView().getItemAtPosition(position).toString();
	    	final TextView txtNow=(TextView)findViewById(R.id.txtNow);
	    	txtNow.setVisibility(0);
	    	txtNow.setText("Now playing: "+itemName.toString());
	    	
	    	//txtNow.setText(String.valueOf(pos));

		    mp.reset();
		    mp.setDataSource(MEDIA_PATH + songs.get(position));
		    mp.prepare();
		    mp.start();
		}
		catch(IOException e) 
		{
			Log.v(getString(R.string.app_name), e.getMessage());
		} 
	}

	

	
}