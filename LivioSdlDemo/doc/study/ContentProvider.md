ContentProvider:  
url: http://developer.android.com/guide/topics/providers/content-providers.html  
���ڻ�ȡ�������͵�����,���Ǵӵ�ǰ���̻�ȡ���������е����ݵı�׼�ӿ�.  

     Context  
 -----------------		req data   
|					|  -------------->   
|	ContentResolver |                    ContentProvider  
|					|   return data  
|					|  <--------------  
 -----------------  

ContentResolver

��ͨ��ʽ: 
1. ��ȡcursor: 
mCursor = getContentResolver().query(..)

2. ����CursorAdapter

mCursorAdapter = new SimpleCursorAdapter(
					    getApplicationContext(),        
					    R.layout.wordlistrow,         
					    mCursor,                     
					    mWordListColumns,          
					    mWordListItems,           
					    0);  

3. ��adapter���õ�listview��. 
mWordList.setAdapter(mCursorAdapter);

�첽��ʽ��ʹ��loader��

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
	


