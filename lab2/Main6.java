import java.util.Scanner; 
class Main6 {
	public static int converter(int a)	{
		return (a / 60) * 100 + (a % 60);
	}
	public static void main(String[] args)	{
		Scanner sc = new Scanner(System.in); 
		int numOfCruise = sc.nextInt();
		Cruise[] cruises = new Cruise[numOfCruise]; 
		for(int i = 0; i < numOfCruise; i++) 	{
			String str = sc.next(); 
			char prefix = str.charAt(0); 
			if (prefix == 'S')	{
				cruises[i] = new SmallCruise(str, sc.nextInt());
			} else { 
				cruises[i] = new BigCruise(str, sc.nextInt(), sc.nextInt(), sc.nextInt());  
			}
		}
		Loader[] loaders = new Loader[270]; 
		for(Cruise cruise : cruises) {
			int loadersNeeded = cruise.getNumOfLoadersRequired(); 
			for(int i = 0; i < 270; i++)	{
				if(loadersNeeded == 0) { 
					break;
				} else { 
					if ((i + 1) % 3 == 0)	{
						if (loaders[i] == null || loaders[i].canServe(cruise))	{
							loaders[i] = new Loader(i + 1).serve(cruise); 
							loadersNeeded = loadersNeeded - 1;
							System.out.println("Loader " + (i + 1) + " (recycled) serving " + cruise.toString());
							loaders[i] = new Loader(i + 1).serve(new Cruise("maintainance",
											converter(cruise.getServiceCompletionTime()), 1, 60));  
						}

					} else {
						if (loaders[i] == null)	{
							loaders[i] = new Loader(i + 1).serve(cruise); 
							loadersNeeded = loadersNeeded - 1;
							System.out.println(loaders[i].toString());  
						} else if (loaders[i].canServe(cruise)) { 
							loaders[i] = new Loader(i + 1).serve(cruise); 
							loadersNeeded = loadersNeeded - 1;
							System.out.println(loaders[i].toString()); 
						} else {}
					}
				}
			}
		} 
			
	}
}
