/** 
    Copyright 2015 Tim Engler, Rareventure LLC

    This file is part of Tiny Travel Tracker.

    Tiny Travel Tracker is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Tiny Travel Tracker is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Tiny Travel Tracker.  If not, see <http://www.gnu.org/licenses/>.

*/
package com.rareventure.gps2.database.cache;

import java.util.ArrayList;

import com.rareventure.android.database.Cache;
import com.rareventure.android.database.DbDatastoreAccessor;
import com.rareventure.android.database.TableInfo;
import com.rareventure.android.encryption.EncryptedRow;

/**
 * A Panel is a 2d object in space. Time is handled by TimeRangePanels 
 * held by Points. 
 */
public class MediaLocTimePlus extends EncryptedRow {
	private static final int MAX_FILEPATH_SIZE = 255;
	
	//x and y are absolute coordinates of the earth in ap panel format
	public static final Column FILE_PATH = new Column("FILE_PATH", MAX_FILEPATH_SIZE );

	public static final Column[] COLUMNS = new Column[] { FILE_PATH };
	
	public static final String TABLE_NAME = "media_loc_time_plus";
	
	public static final String INSERT_STATEMENT = DbDatastoreAccessor.createInsertStatement(TABLE_NAME);
	public static final String UPDATE_STATEMENT = DbDatastoreAccessor.createUpdateStatement(TABLE_NAME);
	public static final String DELETE_STATEMENT = DbDatastoreAccessor.createDeleteStatement(TABLE_NAME);
	
	public static final TableInfo TABLE_INFO = new TableInfo(TABLE_NAME, COLUMNS, INSERT_STATEMENT, UPDATE_STATEMENT,
			DELETE_STATEMENT);

	/**
	 * size of data
	 */
	public static final int DATA_LENGTH = 
		EncryptedRow.figurePosAndSizeForColumns(COLUMNS);
	
	
	public MediaLocTimePlus() {
		super();

	}
	
	public int getDataLength()
	{
		return DATA_LENGTH;
	}
	
	public void setData(String filename) {
		data2 = new byte[DATA_LENGTH];
		
		setString(FILE_PATH.pos,filename, MAX_FILEPATH_SIZE);
	}
	
	public String getFilename()
	{
		return getString(FILE_PATH);
	}
	
	@Override
	public Cache getCache() {
		return null;
	}

}
