import 
return conf.quiet_time['start'] >= datetime.datetime.now().hour >= conf.quiet_time['end']
