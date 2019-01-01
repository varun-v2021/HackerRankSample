import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class CountIndex {
	int count = 1;

	public int getIndex() {
		return count;
	}
}

public class Solution2 {
	static HashMap<Character, CountIndex> myHMap = new HashMap<>();
	static int uniqueCharCount = 0;
	static List<Integer> myList = new ArrayList<Integer>();
	static boolean pFlag = false;
	static boolean cFlag = false;
	static boolean mFlag = false;
	static boolean bFlag = false;
	static boolean zFlag = false;
	static int TeamCounter = 0;
	
	static int differentTeams(String skills) {
		System.out.println(skills);
		char[] skillArray = skills.toCharArray();
		for (char c : skillArray) {
			if(myHMap.containsKey(c)){
				++myHMap.get(c).count;
			}else{
				myHMap.put(c, new CountIndex());
				++uniqueCharCount;
			}
		}
		
		if(uniqueCharCount != 5){
			return 0;
		}else{
			for (Entry<Character, CountIndex> entry : myHMap.entrySet()) {
			    char key = entry.getKey();
			    CountIndex value = entry.getValue();
			    if(key == 'p'){
			    	pFlag = true;
			    }else if(key == 'c'){
			    	cFlag = true;
			    }else if(key == 'm'){
			    	mFlag = true;
			    }else if(key == 'b'){
			    	bFlag = true;
			    }else if(key == 'z'){
			    	zFlag = true;
			    }
				myList.add(value.count);
			    System.out.println(key + " "+value.count);
			    
			}
			
			
		    if(pFlag && cFlag && mFlag && bFlag && zFlag){
		    	countTeam(myList);
		    }else{
		    	return 0;
		    }
		}
		return 0;
	}
	
	public static void countTeam(List<Integer> team){
		List<Integer> nL = new ArrayList<>();
		for(int i=0;i<team.size();i++){
			if(team.get(i) == 0){
				team.remove(i);
				break;
			}else{
				nL.add(team.get(i) -1);
			}
		}
		if(nL.size() == 5){
			++TeamCounter;
		countTeam(nL);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// System.out.println(bufferedReader.readLine().trim());
		differentTeams(bufferedReader.readLine().trim());
	}

}
