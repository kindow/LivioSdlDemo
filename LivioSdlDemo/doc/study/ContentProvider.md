ContentProvider:  
url: http://developer.android.com/guide/topics/providers/content-providers.html  
用于获取复杂类型的数据,它是从当前进程获取其它进程中的数据的标准接口.  

     Context  
 -----------------		req data   
|					|  -------------->   
|	ContentResolver |                    ContentProvider  
|					|   return data  
|					|  <--------------  
 -----------------  

ContentResolver

普通方式: 
1. 获取cursor: 
mCursor = getContentResolver().query(..)

2. 构建CursorAdapter

mCursorAdapter = new SimpleCursorAdapter(
					    getApplicationContext(),        
					    R.layout.wordlistrow,         
					    mCursor,                     
					    mWordListColumns,          
					    mWordListItems,           
					    0);  

3. 将adapter设置到listview中. 
mWordList.setAdapter(mCursorAdapter);

异步方式（使用loader）

onActivityCreated: 
 		setListAdapter(mAdapter);
        getLoaderManager().initLoader(0, null, this);
        
        
onCreateLoader:
	return new CursorLoader(getActivity(), baseUri,
                CONTACTS_SUMMARY_PROJECTION, select, null,
                Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC");

onLoadFinished:
	mAdapter.swapCursor(data);
	
onLoaderReset:
	mAdapter.swapCursor(null);
	


